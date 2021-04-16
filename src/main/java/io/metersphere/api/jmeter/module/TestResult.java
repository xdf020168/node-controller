package io.metersphere.api.jmeter.module;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.common.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestResult {

    private String testId;

    private boolean isDebug;

    private String userId;

    private String runMode;

    private String reportName;

    private int success = 0;

    private int error = 0;

    private int total = 0;

    private int totalAssertions = 0;

    private int passAssertions = 0;

    private List<ScenarioResult> scenarios = new ArrayList<>();

    public void addError(int count) {
        this.error += count;
    }

    public void addSuccess() {
        this.success++;
    }

    public void addTotalAssertions(int count) {
        this.totalAssertions += count;
    }

    public void addPassAssertions(int count) {
        this.passAssertions += count;
    }

    private static final String SEPARATOR = "<->";

    public void addScenario(ScenarioResult result) {
        if (result != null && CollectionUtils.isNotEmpty(result.getRequestResults())) {
            result.getRequestResults().forEach(item -> {
                if (StringUtils.isNotEmpty(item.getName()) && item.getName().indexOf(SEPARATOR) != -1) {
                    String array[] = item.getName().split(SEPARATOR);
                    item.setName(array[1] + array[0]);
                    item.getSubRequestResults().forEach(subItem -> {
                        subItem.setName(array[0]);
                    });
                }
            });
            scenarios.add(result);
        }
    }
}
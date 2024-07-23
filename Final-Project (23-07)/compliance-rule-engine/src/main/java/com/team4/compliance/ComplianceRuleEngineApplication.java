 package com.team4.compliance;

import java.util.List;

public class ComplianceRuleEngineApplication {

    public static void main(String[] args) {
      
        ComplianceRule rule = new ComplianceRule("rule1", "Device ID must be device1", config -> config.getDeviceId().equals("device1"));
        
      
        ComplianceService service = new ComplianceService(List.of(rule));

       
        Configuration config = new Configuration("device1", "{...}");

  
        List<String> result = service.analyzeCompliance(config);

        if (result.isEmpty()) {
            System.out.println("All rules are compliant.");
        } else {
            System.out.println("Non-compliant rules: " + result);
        }
    }
    
}
package com.techlead.service.core1.helper;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TemplateService {

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{\\{([^}]+)\\}\\}");

    public File renderTemplateAndSave(String templateFilePath, Map<String, String> params, String outputPath) throws IOException, Exception {
        // Đọc nội dung template từ file
        String templateContent = readFile(templateFilePath);
        if (templateContent.isEmpty()) {
            throw new Exception("Template content cannot be empty");
        }
        if (params == null) {
            throw new Exception("Parameters cannot be null");
        }

        String renderedContent = replacePlaceholder(templateContent, params);

        // Ghi nội dung vào file
        File outputFile = new File(outputPath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(renderedContent);
        } catch (IOException e) {
            throw new Exception("Error writing to output file: " + outputPath, e);
        }

        return outputFile;
    }

    private String replacePlaceholder(String templateContent, Map<String, String> params) {
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(templateContent);
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;

        while (matcher.find()) {
            result.append(templateContent, lastIndex, matcher.start());
            String paramName = matcher.group(1);
            String replacement = params.getOrDefault(paramName, "{{" + paramName + "}}");
            result.append(replacement);
            lastIndex = matcher.end();
        }

        result.append(templateContent, lastIndex, templateContent.length());
        return result.toString();
    }

    private String readFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new Exception("Template file not found: " + filePath, e);
        } catch (IOException e) {
            throw new Exception("Error reading template file: " + filePath, e);
        }
        return content.toString();
    }
}
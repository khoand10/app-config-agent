package com.nal.demoflumeagent.controller;

import com.nal.demoflumeagent.model.ExecSourceModel;
import com.nal.demoflumeagent.model.HttpSourceModel;
import com.nal.demoflumeagent.model.NetworkSourceModel;
import com.nal.demoflumeagent.utils.CompressAgent;
import com.nal.demoflumeagent.utils.ConfigFlume;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Controller
@RequestMapping("/sys")
public class ConfigController {

    private ConfigFlume configFlume;
    private CompressAgent compressAgent;

    public ConfigController() {
        this.configFlume = new ConfigFlume();
        this.compressAgent = new CompressAgent();
    }

    @GetMapping("/config")
    public ModelAndView getConfig() {
        ExecSourceModel execSourceModel = new ExecSourceModel();
        HttpSourceModel httpSourceModel = new HttpSourceModel();
        NetworkSourceModel networkSourceModel = new NetworkSourceModel();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("execSourceModel", execSourceModel);
        modelAndView.addObject("httpSourceModel", httpSourceModel);
        modelAndView.addObject("networkSourceModel", networkSourceModel);
        return modelAndView;
    }

    @PostMapping("/download/exec")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadFile(@ModelAttribute("execSourceModel") ExecSourceModel execSourceModel) {

        System.out.println(execSourceModel.toString());
        configFlume.configExecSource(execSourceModel);
        compressAgent.zipDirectory();
        File file = new java.io.File(CompressAgent.OUTPUT_ZIP_FILE);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.MULTIPART_FORM_DATA).contentLength(file.length())
                .body(resource);
    }

    @PostMapping("/download/http")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadHttpSource (@ModelAttribute("httpSourceModel") HttpSourceModel httpSourceModel) {
        System.out.println(httpSourceModel.toString());
        configFlume.configHttpSource(httpSourceModel);
        compressAgent.zipDirectory();
        File file = new java.io.File(CompressAgent.OUTPUT_ZIP_FILE);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.MULTIPART_FORM_DATA).contentLength(file.length())
                .body(resource);
    }

    @PostMapping("/download/network")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downloadFile(@ModelAttribute("networkSourceModel") NetworkSourceModel networkSourceModel) {

        System.out.println(networkSourceModel.toString());
        configFlume.configNetworkSource(networkSourceModel);
        compressAgent.zipDirectory();
        File file = new java.io.File(CompressAgent.OUTPUT_ZIP_FILE);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.MULTIPART_FORM_DATA).contentLength(file.length())
                .body(resource);
    }

}


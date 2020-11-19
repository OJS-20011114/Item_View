package io.jenkins.plugins.sample;


import hudson.FilePath;
import hudson.model.AbstractBuild;
import hudson.model.Action;

import java.util.Arrays;
import java.io.*;
import javax.servlet.ServletOutputStream;
import java.lang.Integer;

import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;
import org.kohsuke.stapler.DataBoundConstructor;


public class BuildHis_Act implements Action {

    private AbstractBuild AbBuild;//중요
    String[] Split_str = {};
    public BuildHis_Act(AbstractBuild AbBuild)//중요
    {
        this.AbBuild = AbBuild;
        String ss = this.AbBuild.toString();//
        Split_str = ss.split(" #");//마지막 빌드 번호 받아오기
    }
    public AbstractBuild getBuild()
    {
        return this.AbBuild;
    }
    public String getLastBuildNumber_01()
    {
        return Split_str[0];
    }
    
    public String getLastBuildNumber_02()
    {
        return Split_str[1];
    }
    public String getLog()
    {
        return "Log Get";
    }
    //
    public String getDisplayName() {
		return "빌드 출력";
	}

	public String getIconFileName() {
		return "clipboard.png";
	}

	public String getUrlName() {
		return "Example";
    }
    //
    
   
}

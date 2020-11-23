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
    public BuildHis_Act(AbstractBuild AbBuild)
    {
        this.AbBuild = AbBuild;//Ex (Job 이름) #(현재 빌드 번호)
        String ss = this.AbBuild.toString();//String 변환
        Split_str = ss.split(" #");//현재 빌드 번호 받아오기
    }
    public AbstractBuild getBuild()//.jelly파일에서 값을 사용 시 ${it.변수 이름} 같이 사용해야 하며, 해당 파일 에서는 함수 이름 앞에 get을 붙여야 한다.
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

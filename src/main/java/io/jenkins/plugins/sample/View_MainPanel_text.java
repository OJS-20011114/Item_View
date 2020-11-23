package io.jenkins.plugins.sample;

import hudson.model.Action;
import hudson.model.Project;
import java.util.Collection;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import hudson.Extension;
import jenkins.model.TransientActionFactory;

public class View_MainPanel_text implements Action {

    private Project project;//중요 1

    public View_MainPanel_text(Project project) {
        this.project = project;
    }
    
    public int getBuildStepsCount() {
        return project.getBuilders().size();
    }//해당 Job 빌드 옵션 개수

    public int getPostBuildStepsCount() {
        return project.getPublishersList().size();
    }//해당 Job Post-빌드 옵션 개수
    public String getLog()
    {
        //로그가 저장될 변수
        String Log_Value="";
        try {
            Log_Value = "1029384756";
        } catch (Exception e) {
            Log_Value="Null_Log";
        }
        return Log_Value;
    }//for문에 사용되면서 해당 빌드의 로그를 전달한다.

    @Override
    public String getIconFileName() {
        return "clipboard.png";
    }

    @Override
    public String getDisplayName() {
        return "빌드 현황";
    }

    @Override
    public String getUrlName() {
        return "buildStats";
    }
    @Extension
    public static class View_all extends TransientActionFactory<Project>/*중요 2*/ {
    
        @Override
        public Class<Project> type() {
            return Project.class; 
        }
    
        @Override
        public Collection<? extends Action> createFor(/*@NonNull*/ Project project) {
            return Collections.singleton(new View_MainPanel_text(project)); 
        }
    
        
    // @NonNull
    
    
    }
    
    
}//여기서 프로젝트에 관한 값들을 받아온다.


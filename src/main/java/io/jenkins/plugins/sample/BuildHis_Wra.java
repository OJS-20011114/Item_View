package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildWrapper;
import hudson.tasks.BuildWrapperDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import java.io.IOException;
import java.io.OutputStream;

import org.kohsuke.stapler.DataBoundConstructor;


public class BuildHis_Wra extends BuildWrapper {

    @DataBoundConstructor//무조건 들어가야함.
	public BuildHis_Wra() {}
    @Override
    public Environment setUp(AbstractBuild build, Launcher launcher,
			BuildListener listener) throws IOException, InterruptedException {
                //
                final BuildHis_Act action = new BuildHis_Act(build);
                build.addAction(action);
                //중요 포인트(1)
                return new Environment()
                {
                    public boolean tearDown(AbstractBuild build, Launcher launcher, BuildListener listener)throws IOException, InterruptedException
                    {
                        return true;
                    }
                        
                    
                }; 
            }
            @Extension
            public static final class DescriptorImpl extends BuildWrapperDescriptor {
                @Override
                public String getDisplayName() {
                    return "View_Build_Text";
                }
        
                @Override
                public boolean isApplicable(AbstractProject<?, ?> item) {
                    return true;
                }
            }//Job 설정 - 빌드 환경에 나타날 이름과 visible 지정
}
// String path = build.getArtifactsDir().getCanonicalPath() + "/Example";
//                         File History_Path = new File(path);
//                         History_Path.mkdirs();

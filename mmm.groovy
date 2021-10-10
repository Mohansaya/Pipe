pipline{
    agent any 
    stages{
        stage('SCM'){
            steps{
                git url: "https://github.com/Mohansaya/Pipe.git"
            }
        }
        stage(build){
       steps{
           sshPublisher(publishers: [sshPublisherDesc(configName: 'webserver', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'apt-get update', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '**/*.html')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
       }
        }
    }
}

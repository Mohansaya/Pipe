pipeline{
    agent any
        stages{
            stage('SCM'){
                steps{
                    git url:"https://github.com/musthaq2810/webserver_pipeline.git"
                }
            }
            stage('ArchiveArtifacts'){
                steps{
                    archiveArtifacts '**/*.html'
                }
            }
            stage('Build'){
                steps{
                    sshPublisher(publishers: [sshPublisherDesc(configName: 'webserver', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '**/*.html')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                }
            }
        }
    }

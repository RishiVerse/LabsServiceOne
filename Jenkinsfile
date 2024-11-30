pipeline {
    agent any
    tools{
        maven 'maven_3_5_0'
    }
    stages{
        stage('Build Maven'){
            steps{
        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RishiVerse/LabsServiceOne']])
        sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t rishahm148/labs .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                  withCredentials([string(credentialsId: '941a4e5c-b1ab-4bd0-bc08-6c7ffca6d38e', variable: 'dockerpwd')])  {
                   sh 'docker login -u rishabhm148 -p ${dockerpwd}'

}
                   sh 'docker push rishabhm148/labs-app:v7'
                }
            }
        }
//         stage('Deploy to k8s'){
//             steps{
//                 script{
//                     kubernetesDeploy (configs: 'labsapp-service.yaml',kubeconfigId: 'k8sconfigpwd')
//                 }
//             }
//         }
    }
}
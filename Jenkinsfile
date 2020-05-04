pipeline
{
    environment
    {
        registry = "gauravishaandixit/spe_calculator"
        registryCredential = 'DockerHub'
        dockerImage = ''
        dockerImageLatest = ''
    }
    agent any
    stages
    {
        stage('Git-Checkout')
        {
            steps
            {
                echo 'Pulling the Maven Git repo'
                git "https://github.com/gauravishaandixit/SPECalculator.git"
            }
        }

        stage("Clean the maven project")
        {
            steps
            {
                echo "Cleaning the project"
                sh " mvn clean"
            }
        }
        stage("Package the maven project")
        {
            steps
            {
                echo "Packaging the project"
                sh "mvn package"
            }
        }
        stage("Install the project")
        {
            steps
            {
                echo "Installing the project"
                sh "mvn install"
            }
        }
        stage('Building Image')
        {
            steps
            {
                script
                {
                  dockerImage = docker.build registry + ":$BUILD_NUMBER"
                  dockerImageLatest = docker.build registry + ":latest"
                }
            }
        }
        stage('Deploy Image to DockerHub')
        {
            steps
            {
                script
                {
                    docker.withRegistry( '', registryCredential )
                    {
                        dockerImage.push()
                        dockerImageLatest.push()
                    }
                }
            }
        }
        stage('Remove Unused docker image')
        {
            steps
            {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
        stage("Running the main Calculator file")
        {
            steps
            {
                echo "Run the Calculator"
                sh "java -cp target/SPECalculator.jar Calculator 3+5*7/3"
            }
        }
    }
}
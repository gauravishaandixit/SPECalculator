pipeline
{
    agent any
    stages
    {

        stage('Git-Checkout')
        {
            steps
            {
                echo 'Pulling the Maven Git repo'
                git "https://github.com/gauravishaandixit/SPE_Calculator.git"
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

        stage("Install the peoject")
        {
            steps
            {
                echo "Installing the project"
                sh "mvn install"
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
import subprocess
import sys
import boto3

s3 = boto3.client('s3')

def main(argv):
    cmd = argv
    kickoff_subprocess(cmd)
    upload_output_to_S3("output_file.txt")

def kickoff_subprocess(cmd):
    process = subprocess.Popen(cmd, stdout=subprocess.PIPE, shell=True)
    (process_output, error) = process.communicate()
    file = open("output_file.txt", "wb")
    file.write(process_output)

def upload_output_to_S3(filename):
    f = open("example", "rb")
    s3.upload_fileobj(f, "BUCKET_NAME", "OBJECT_NAME")

if __name__ == "__main__":
   main(sys.argv[1:])
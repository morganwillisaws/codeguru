package com.mycompany.app.model;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.*;

/**
 * Upload a file to an Amazon S3 bucket.
 * <p>
 * This code expects that you have AWS credentials set up per:
 * http://docs.aws.amazon.com/java-sdk/latest/developer-guide/setup-credentials.html
 */
public class S3Upload {
    public static void main(String[] args) {
        String bucket_name = "aws_s3_bucket";
        String file_path = "file_name";
        String key_name = "example.txt";
        String fileContents = readFileContents();

        System.out.format("Uploading %s to S3 bucket %s...\n", file_path, bucket_name);
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.DEFAULT_REGION).build();
        try {
            s3.putObject(bucket_name, key_name, new File(fileContents));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }

    private static String readFileContents() {
        BufferedReader reader = null;
        String fileContents = "";
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\example.txt"));

            while (true) {
                fileContents += reader.readLine();
                if (fileContents == null || fileContents.equals("")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        return fileContents;
    }


}
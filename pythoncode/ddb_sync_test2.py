import boto3

def syncTables(event, context):
    source_ddb = boto3.client('dynamodb', 'us-east-1')
    destination_ddb = boto3.client('dynamodb', 'us-west-2')
    sync_ddb_table(source_ddb, destination_ddb)

# Scan returns paginated results, so only partial data will be copied
def sync_ddb_table(source_ddb, destination_ddb):
    response = source_ddb.scan(
        TableName="table1"
    )

    for item in response['Items']:
        destination_ddb.put_item(
            TableName="table2",
            Item=item
        )
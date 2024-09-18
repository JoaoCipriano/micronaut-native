provider "aws" {
  alias                       = "localstack"
  region                      = "us-east-1"  # You can set this to any AWS region
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true
  endpoints {
    dynamodb = "http://localhost:4566" # Use the LocalStack endpoint
  }
}

resource "aws_dynamodb_table" "membership_configuration" {
  provider      = aws.localstack  # Use the LocalStack-specific provider alias
  name          = "membership_configuration"
  billing_mode  = "PAY_PER_REQUEST"
  hash_key      = "id"
  range_key     = "priority"

  attribute {
    name = "id"
    type = "S"
  }
  attribute {
    name = "priority"
    type = "N"
  }
}
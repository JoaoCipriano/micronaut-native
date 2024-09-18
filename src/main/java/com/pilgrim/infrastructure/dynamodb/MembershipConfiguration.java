package com.pilgrim.infrastructure.dynamodb;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Setter
@Builder
@ToString
@Serdeable
@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
public class MembershipConfiguration {

    private String id;

    private Integer priority;

    private String description;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    @DynamoDbSortKey
    public Integer getPriority() {
        return priority;
    }

    @DynamoDbAttribute("description")
    public String getDescription() {
        return description;
    }
}

package com.pilgrim.infrastructure.dynamodb;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class DynamoRepository {

    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public MembershipConfiguration getItem(String id, Integer priority) {
        return getMappedTable(MembershipConfiguration.class)
                .getItem(Key.builder()
                        .partitionValue(id)
                        .sortValue(priority)
                        .build()
                );
    }

    public void save(MembershipConfiguration article) {
        getMappedTable(MembershipConfiguration.class).putItem(article);
    }

    public List<MembershipConfiguration> scan() {
        return getMappedTable(MembershipConfiguration.class).scan().items().stream().toList();
    }

    private <T> DynamoDbTable<T> getMappedTable(Class<T> type) {
        return dynamoDbEnhancedClient.table("membership_configuration", TableSchema.fromBean(type));
    }
}
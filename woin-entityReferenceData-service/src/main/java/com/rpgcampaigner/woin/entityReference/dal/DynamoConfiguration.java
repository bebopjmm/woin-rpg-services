package com.rpgcampaigner.woin.entityReference.dal;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

/**
 * @author jmccormick
 * @since 6/14/17
 */
public class DynamoConfiguration {
	private static final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
	private static final DynamoDB dynamoDB = new DynamoDB(client);

	private final String referenceTable;

	public DynamoConfiguration(String referenceTable) {
		this.referenceTable = referenceTable;
	}

	public Table referenceTable() {
		return dynamoDB.getTable(this.referenceTable);
	}
}

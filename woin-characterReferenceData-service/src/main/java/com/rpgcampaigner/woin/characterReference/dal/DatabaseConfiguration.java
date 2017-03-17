package com.rpgcampaigner.woin.characterReference.dal;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

/**
 * @author jmccormick
 * @since 3/17/17
 */
public class DatabaseConfiguration {

	private Cluster referenceCluster;

	private Bucket referenceBucket;

	public DatabaseConfiguration(String hostname, String referenceBucketName) {
		this.referenceCluster = CouchbaseCluster.create(hostname);
		this.referenceBucket = this.referenceCluster.openBucket(referenceBucketName);
	}

	public Bucket getReferenceBucket() {
		return referenceBucket;
	}
}

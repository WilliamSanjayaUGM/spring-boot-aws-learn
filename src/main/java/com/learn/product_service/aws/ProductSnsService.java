package com.learn.product_service.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learn.product_service.entity.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductSnsService {
	
	@Value("${aws.sns.topic.arn}")
    private String productTopicArn;
	
	private final SnsClient snsClient;
	
	public void publishToSns(Product product) {
		String message = String.format("Product Created! ID: %d, Name: %s, Price: %s", 
                product.getId(), product.getProductName(), product.getPrice());

        PublishRequest request = PublishRequest.builder()
                .message(message)
                .topicArn(productTopicArn)
                .build();

        try {
            PublishResponse response = snsClient.publish(request);
            log.info("Message published successfully. Message ID: " + response.messageId());
        } catch (Exception e) {
            log.error("Failed to publish to SNS: " + e.getMessage());
        }
	}
}

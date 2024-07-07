package com.car.search.carsearchapp.dto;


/**
 * Data Transfer Object (DTO) representing search parameters for cars.
 */
public class SearchParams {
    
	 private Double length;
	    private Double minLength;
	    private Double maxLength;
	    private Double weight;
	    private Double minWeight;
	    private Double maxWeight;
	    private Double velocity;
	    private Double minVelocity;
	    private Double maxVelocity;
	    private String color;
		public Double getLength() {
			return length;
		}
		public void setLength(Double length) {
			this.length = length;
		}
		public Double getMinLength() {
			return minLength;
		}
		public void setMinLength(Double minLength) {
			this.minLength = minLength;
		}
		public Double getMaxLength() {
			return maxLength;
		}
		public void setMaxLength(Double maxLength) {
			this.maxLength = maxLength;
		}
		public Double getWeight() {
			return weight;
		}
		public void setWeight(Double weight) {
			this.weight = weight;
		}
		public Double getMinWeight() {
			return minWeight;
		}
		public void setMinWeight(Double minWeight) {
			this.minWeight = minWeight;
		}
		public Double getMaxWeight() {
			return maxWeight;
		}
		public void setMaxWeight(Double maxWeight) {
			this.maxWeight = maxWeight;
		}
		public Double getVelocity() {
			return velocity;
		}
		public void setVelocity(Double velocity) {
			this.velocity = velocity;
		}
		public Double getMinVelocity() {
			return minVelocity;
		}
		public void setMinVelocity(Double minVelocity) {
			this.minVelocity = minVelocity;
		}
		public Double getMaxVelocity() {
			return maxVelocity;
		}
		public void setMaxVelocity(Double maxVelocity) {
			this.maxVelocity = maxVelocity;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
   
}

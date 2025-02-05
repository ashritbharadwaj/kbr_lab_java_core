package com.currencyexchange.repo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ExchangeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	
	private BigDecimal conversionMultiple;

	private int port;

	public ExchangeValue(String from, String to, BigDecimal conversionMultiple) {
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public ExchangeValue() {

	}

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple, int port) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ExchangeValue{");
		sb.append("id=").append(id);
		sb.append(", from='").append(from).append('\'');
		sb.append(", to='").append(to).append('\'');
		sb.append(", conversionMultiple=").append(conversionMultiple);
		sb.append(", port=").append(port);
		sb.append('}');
		return sb.toString();
	}
}
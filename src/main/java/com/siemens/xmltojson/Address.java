package com.siemens.xmltojson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
	public String city;
    public String street;
    public String state;
    public String pincode;
	@Override
	public String toString() {
		return "[city=" + city + ", street=" + street + ", state=" + state + ", pincode=" + pincode + "]";
	}
    
}

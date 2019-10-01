package com.example.demo.model;

import com.example.demo.util.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCallback {

    private String txnid;
    private String mihpayid;
    private PaymentMode mode;
    private String status;
    private String hash;
}
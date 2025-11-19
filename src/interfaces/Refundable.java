package src.interfaces;

import src.exception.NonRefundableException;

public interface Refundable {
    void refund() throws NonRefundableException;
}

package com.dfesh.co.moneytransfers.application.port.out;

import com.dfesh.co.moneytransfers.domain.Account;

public interface UpdateAccountPort {

    void update(Account account);
}

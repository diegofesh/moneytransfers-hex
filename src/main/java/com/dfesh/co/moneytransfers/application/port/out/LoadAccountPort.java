package com.dfesh.co.moneytransfers.application.port.out;

import com.dfesh.co.moneytransfers.domain.Account;

public interface LoadAccountPort {

    Account load(Long id);
}

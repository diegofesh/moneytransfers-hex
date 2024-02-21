package com.dfesh.co.moneytransfers.adapter.out.persistence;

import com.dfesh.co.moneytransfers.application.port.out.LoadAccountPort;
import com.dfesh.co.moneytransfers.application.port.out.UpdateAccountPort;
import com.dfesh.co.moneytransfers.common.PersistenceAdapter;
import com.dfesh.co.moneytransfers.domain.Account;

@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountPort {

    private final SpringAccountRepository accountRepository;

    public AccountPersistenceAdapter(SpringAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account load(Long id) {
        return accountRepository
                .findById(id)
                .map(AccountMapper::entityToDomain)
                .orElseThrow(RuntimeException::new); // mejorar exception
    }

    @Override
    public void update(Account account) {
        accountRepository.save(AccountMapper.domainToEntity(account));
    }
}

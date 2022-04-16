package com.fhk.sample.service.impl;


@Service("accountService")
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Account> page = this.page(
                new Query<Account>().getPage(params),
                new QueryWrapper<Account>()
        );

        return new PageUtils(page);
    }

}
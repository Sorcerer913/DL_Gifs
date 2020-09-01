package com.maximemelianov.dlgifs.view;

import com.maximemelianov.dlgifs.model.PostData;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface IMainView extends MvpView {
    @StateStrategyType(OneExecutionStateStrategy.class)
    void loading();

    @StateStrategyType(SingleStateStrategy.class)
    void success(PostData data);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void error();
    @StateStrategyType(SingleStateStrategy.class)
    void prevEnabled(boolean enabled);

}

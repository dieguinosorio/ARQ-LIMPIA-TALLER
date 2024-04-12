package com.market.commons;

public interface UseCase<Input,Output> {
    Output execute(Input input);
}

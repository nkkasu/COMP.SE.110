package fi.tuni.monitor.data;

import java.util.concurrent.CompletableFuture;

/**
 * Interface for classes that need to tell if their async data fetch is complete
 */
public interface AsyncDataFetch {
    CompletableFuture<Void> getIsDataFetchComplete();
}

package org.citykarat_new.tradereconciliation;

import java.util.List;

public class TradeReconciliationService {

    /*
     * TASK 2:
     * Return incoming trades that are NOT present in bookedTrades.
     *
     * Requirements:
     * - Preserve incoming order.
     * - Do not mutate either input list.
     * - Duplicate business-identical trades should be handled correctly.
     */
    public List<Trade> findUnmatchedIncomingTrades(List<Trade> incomingTrades,
                                                  List<Trade> bookedTrades) {
        throw new UnsupportedOperationException("TODO: implement findUnmatchedIncomingTrades");
    }

    /*
     * TASK 3:
     * Return true only when every incoming trade has a corresponding
     * booked trade.
     *
     * Think about duplicate trades and whether simple Set logic is enough.
     */
    public boolean isFullyReconciled(List<Trade> incomingTrades,
                                     List<Trade> bookedTrades) {
        throw new UnsupportedOperationException("TODO: implement isFullyReconciled");
    }
}

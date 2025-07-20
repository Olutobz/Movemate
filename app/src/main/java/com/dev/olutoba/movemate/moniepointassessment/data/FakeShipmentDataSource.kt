package com.dev.olutoba.movemate.moniepointassessment.data

import com.dev.olutoba.movemate.moniepointassessment.models.ShipmentItem
import com.dev.olutoba.movemate.moniepointassessment.models.ShipmentStatus

object FakeShipmentDataSource {
    private val RANGE = 1..5

    private val inProgressShipments = (1..3).map {
        createShipmentItem(it, ShipmentStatus.IN_PROGRESS)
    }

    private val completedShipments = (4..6).map {
        createShipmentItem(it, ShipmentStatus.COMPLETED)
    }

    private val pendingShipments = (7..11).map {
        createShipmentItem(it, ShipmentStatus.PENDING)
    }

    private val cancelledShipments = (12..16).map {
        createShipmentItem(it, ShipmentStatus.CANCELED)
    }

    private fun createShipmentItem(it: Int, status: ShipmentStatus): ShipmentItem {
        return ShipmentItem(
            status = status,
            arrival = "Arriving today!",
            date = "May 20, 2025",
            packageId = "#NEJ20068289341${it}231$it",
            location = "Atlanta",
            price = "${(100 * it) + 50}",
            key = it
        )
    }

    val shipments =
        completedShipments + inProgressShipments + pendingShipments + cancelledShipments
}
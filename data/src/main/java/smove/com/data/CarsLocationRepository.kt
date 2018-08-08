package smove.com.data

import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import smove.com.network.model.CarInfo

/**
 * @Author rahulravindran
 */
class CarsLocationRepository: BaseRepository<CarInfo>() {

    fun fetchCars() {

    }

    override fun fetch(key: Any): Single<CarInfo> {

    }
}
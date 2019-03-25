package no.nav.pam.feed.ad

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import no.nav.pam.feed.Environment
import java.time.ZonedDateTime

val env: Environment = Environment()

@JsonIgnoreProperties(ignoreUnknown = true)
data class FeedRoot(val content: List<FeedAd>,
                    val totalElements: Int,
                    val number: Int,
                    val size: Int) {
    val totalPages: Int = totalElements / size
    val first: Boolean = number == 0
    val last: Boolean = number == totalPages
}

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
data class FeedAd(val uuid: String,
//                  val created: ZonedDateTime,
//                  val updated: ZonedDateTime,
                  val published: ZonedDateTime,
                  val expires: ZonedDateTime,
                  val workLocations: List<FeedLocation>,
                  val title: String,
                  val reference: String,
                  val employer: String,
                  val description: String?,
                  val sourceLink: String?,
                  val applicationdue: String?,
//                  val engagementtype: String?,
//                  val extent: String?,
                  val occupation: String?,
//                  val positioncount: Int?,
//                  val sector: String?,
                  val industry: String?) {

    val testurl: String = env.arbeidsplassenHost
    val link: String = "/stillinger/stilling/$uuid"
}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class FeedLocation(val country: String,
                        val address: String?,
                        val city: String?,
                        val postalCode: String?,
                        val county: String?,
                        val municipal: String?)
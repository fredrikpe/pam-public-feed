package no.nav.pam.feed.ad

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class FeedRoot(val total: Int, val ads: List<FeedAd>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class FeedAd(val uuid: String,
                  val created: String,
                  val updated: String,
                  val published: String,
                  val expires: String,
                  val locations: List<FeedLocation>,
                  val title: String,
                  val source: String,
                  val medium: String,
                  val reference: String,
                  val employer: String,
                  val adtext: String?,
                  val sourceurl: String?,
                  val applicationdue: String?,
                  val engagementtype: String?,
                  val extent: String?,
                  val occupation: String?,
                  val positioncount: Int?,
                  val sector: String?,
                  val industry: String?)

@JsonIgnoreProperties(ignoreUnknown = true)
data class FeedLocation(val country: String,
                        val address: String?,
                        val city: String?,
                        val postalCode: String?,
                        val county: String?,
                        val municipal: String?)
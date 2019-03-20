package no.nav.pam.feed.ad

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.ZonedDateTime


@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchResponseRoot(val hits: Hits)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Hits(val total: Int, val hits: ArrayList<Hit>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Hit(@JsonProperty("_source") val source: Source)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Source(val uuid: String,
                  @JsonDeserialize(using = CustomDateTimeDeserializer::class)
                  val created: ZonedDateTime,
                  @JsonDeserialize(using = CustomDateTimeDeserializer::class)
                  val updated: ZonedDateTime,
                  @JsonDeserialize(using = CustomDateTimeDeserializer::class)
                  val published: ZonedDateTime,
                  @JsonDeserialize(using = CustomDateTimeDeserializer::class)
                  val expires: ZonedDateTime,
                  val title: String,
                  val source: String,
                  val medium: String,
                  val reference: String,
                  val businessName: String?,
                  @JsonProperty("locationList") val locations: List<Location>,
                  val properties: Map<String, String>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Location(val country: String,
                    val address: String?,
                    val city: String?,
                    val postalCode: String?,
                    val county: String?,
                    val municipal: String?)

class CustomDateTimeDeserializer : StdDeserializer<ZonedDateTime>(ZonedDateTime::class.java) {
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): ZonedDateTime {
        val value = jp.codec.readValue(jp, String::class.java)

        return ZonedDateTime.parse(value)
    }
}
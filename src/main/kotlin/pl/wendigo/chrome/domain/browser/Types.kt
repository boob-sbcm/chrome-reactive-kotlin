package pl.wendigo.chrome.domain.browser

/**
 *
 */

typealias WindowID = Int

/**
 * The state of the browser window.
 */
enum class WindowState {
    @com.fasterxml.jackson.annotation.JsonProperty("normal") NORMAL,
    @com.fasterxml.jackson.annotation.JsonProperty("minimized") MINIMIZED,
    @com.fasterxml.jackson.annotation.JsonProperty("maximized") MAXIMIZED,
    @com.fasterxml.jackson.annotation.JsonProperty("fullscreen") FULLSCREEN;
}

/**
 * Browser window bounds information
 */

data class Bounds(
  /**
   * The offset from the left edge of the screen to the window in pixels.
   */
  val left : Int? = null,

  /**
   * The offset from the top edge of the screen to the window in pixels.
   */
  val top : Int? = null,

  /**
   * The window width in pixels.
   */
  val width : Int? = null,

  /**
   * The window height in pixels.
   */
  val height : Int? = null,

  /**
   * The window state. Default to normal.
   */
  val windowState : WindowState? = null
)

/**
 * Chrome histogram bucket.
 */

data class Bucket(
  /**
   * Minimum value (inclusive).
   */
  val low : Int,

  /**
   * Maximum value (exclusive).
   */
  val high : Int,

  /**
   * Number of samples.
   */
  val count : Int
)

/**
 * Chrome histogram.
 */

data class Histogram(
  /**
   * Name.
   */
  val name : String,

  /**
   * Sum of sample values.
   */
  val sum : Int,

  /**
   * Total number of samples.
   */
  val count : Int,

  /**
   * Buckets.
   */
  val buckets : List<Bucket>
)


package pl.wendigo.chrome.domain.deviceorientation

/**
 * DeviceOrientationDomain represents remote debugger protocol domain.
 *
 * This class was autogenerated by main.go. Do not edit :)
 */
@pl.wendigo.chrome.ProtocolExperimental class DeviceOrientationDomain internal constructor(private val connection : pl.wendigo.chrome.RemoteChromeConnection) {

	/**
	 * Overrides the Device Orientation.
	 */
	  fun setDeviceOrientationOverride(input : SetDeviceOrientationOverrideRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("DeviceOrientation.setDeviceOrientationOverride", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Clears the overridden Device Orientation.
	 */
	  fun clearDeviceOrientationOverride() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("DeviceOrientation.clearDeviceOrientationOverride", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

  }

/**
 * Represents request parameters that can be used with DeviceOrientation.setDeviceOrientationOverride method call.
 *
 * Overrides the Device Orientation.
 */
data class SetDeviceOrientationOverrideRequest (
    /**
     * Mock alpha
     */
    val alpha : Double,

    /**
     * Mock beta
     */
    val beta : Double,

    /**
     * Mock gamma
     */
    val gamma : Double

)






package pl.wendigo.chrome.domain.heapprofiler

/**
 * HeapProfilerDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class HeapProfilerDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * 
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun startTrackingHeapObjects(input : StartTrackingHeapObjectsRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.startTrackingHeapObjects", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun stopTrackingHeapObjects(input : StopTrackingHeapObjectsRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.stopTrackingHeapObjects", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun takeHeapSnapshot(input : TakeHeapSnapshotRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.takeHeapSnapshot", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun collectGarbage() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.collectGarbage", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun getObjectByHeapObjectId(input : GetObjectByHeapObjectIdRequest) : io.reactivex.Flowable<GetObjectByHeapObjectIdResponse> {
        return connection.runAndCaptureResponse("HeapProfiler.getObjectByHeapObjectId", input, GetObjectByHeapObjectIdResponse::class.java)
	}

	/**
	 * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
	 */
	  fun addInspectedHeapObject(input : AddInspectedHeapObjectRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.addInspectedHeapObject", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun getHeapObjectId(input : GetHeapObjectIdRequest) : io.reactivex.Flowable<GetHeapObjectIdResponse> {
        return connection.runAndCaptureResponse("HeapProfiler.getHeapObjectId", input, GetHeapObjectIdResponse::class.java)
	}

	/**
	 * 
	 */
	  fun startSampling(input : StartSamplingRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("HeapProfiler.startSampling", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun stopSampling() : io.reactivex.Flowable<StopSamplingResponse> {
        return connection.runAndCaptureResponse("HeapProfiler.stopSampling", null, StopSamplingResponse::class.java)
	}

  
  /**
   * 
   */
   fun addHeapSnapshotChunk() : io.reactivex.Flowable<AddHeapSnapshotChunkEvent> {
      return connection.captureEvents("HeapProfiler.addHeapSnapshotChunk", AddHeapSnapshotChunkEvent::class.java)
   }

  /**
   * 
   */
   fun resetProfiles() : io.reactivex.Flowable<pl.wendigo.chrome.DebuggerEvent> {
      return connection.captureEvents("HeapProfiler.resetProfiles", pl.wendigo.chrome.DebuggerEvent::class.java)
   }

  /**
   * 
   */
   fun reportHeapSnapshotProgress() : io.reactivex.Flowable<ReportHeapSnapshotProgressEvent> {
      return connection.captureEvents("HeapProfiler.reportHeapSnapshotProgress", ReportHeapSnapshotProgressEvent::class.java)
   }

  /**
   * If heap objects tracking has been started then backend regulary sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
   */
   fun lastSeenObjectId() : io.reactivex.Flowable<LastSeenObjectIdEvent> {
      return connection.captureEvents("HeapProfiler.lastSeenObjectId", LastSeenObjectIdEvent::class.java)
   }

  /**
   * If heap objects tracking has been started then backend may send update for one or more fragments
   */
   fun heapStatsUpdate() : io.reactivex.Flowable<HeapStatsUpdateEvent> {
      return connection.captureEvents("HeapProfiler.heapStatsUpdate", HeapStatsUpdateEvent::class.java)
   }
}





/**
 * Represents requestFrame parameters that can be used with HeapProfiler.startTrackingHeapObjects method call.
 *
 * 
 */
data class StartTrackingHeapObjectsRequest (
    /**
     * 
     */
    val trackAllocations : Boolean? = null

)


/**
 * Represents requestFrame parameters that can be used with HeapProfiler.stopTrackingHeapObjects method call.
 *
 * 
 */
data class StopTrackingHeapObjectsRequest (
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken when the tracking is stopped.
     */
    val reportProgress : Boolean? = null

)


/**
 * Represents requestFrame parameters that can be used with HeapProfiler.takeHeapSnapshot method call.
 *
 * 
 */
data class TakeHeapSnapshotRequest (
    /**
     * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
     */
    val reportProgress : Boolean? = null

)




/**
 * Represents requestFrame parameters that can be used with HeapProfiler.getObjectByHeapObjectId method call.
 *
 * 
 */
data class GetObjectByHeapObjectIdRequest (
    /**
     * 
     */
    val objectId : HeapSnapshotObjectId,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup : String? = null

)

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * 
 */
data class GetObjectByHeapObjectIdResponse(
  /**
   * Evaluation result.
   */
  val result : pl.wendigo.chrome.domain.runtime.RemoteObject

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.addInspectedHeapObject method call.
 *
 * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
 */
data class AddInspectedHeapObjectRequest (
    /**
     * Heap snapshot object id to be accessible by means of $x command line API.
     */
    val heapObjectId : HeapSnapshotObjectId

)


/**
 * Represents requestFrame parameters that can be used with HeapProfiler.getHeapObjectId method call.
 *
 * 
 */
data class GetHeapObjectIdRequest (
    /**
     * Identifier of the object to get heap object id for.
     */
    val objectId : pl.wendigo.chrome.domain.runtime.RemoteObjectId

)

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * 
 */
data class GetHeapObjectIdResponse(
  /**
   * Id of the heap snapshot object corresponding to the passed remote object id.
   */
  val heapSnapshotObjectId : HeapSnapshotObjectId

)

/**
 * Represents requestFrame parameters that can be used with HeapProfiler.startSampling method call.
 *
 * 
 */
data class StartSamplingRequest (
    /**
     * Average sample interval in bytes. Poisson distribution is used for the intervals. The default value is 32768 bytes.
     */
    val samplingInterval : Double? = null

)



/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * 
 */
data class StopSamplingResponse(
  /**
   * Recorded sampling heap profile.
   */
  val profile : SamplingHeapProfile

)


/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * 
 */
data class AddHeapSnapshotChunkEvent(
  /**
   * 
   */
  val chunk : String

) : pl.wendigo.chrome.DebuggerEvent(domain = "HeapProfiler", name = "addHeapSnapshotChunk")


/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * 
 */
data class ReportHeapSnapshotProgressEvent(
  /**
   * 
   */
  val done : Int,

  /**
   * 
   */
  val total : Int,

  /**
   * 
   */
  val finished : Boolean? = null

) : pl.wendigo.chrome.DebuggerEvent(domain = "HeapProfiler", name = "reportHeapSnapshotProgress")

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * If heap objects tracking has been started then backend regulary sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
 */
data class LastSeenObjectIdEvent(
  /**
   * 
   */
  val lastSeenObjectId : Int,

  /**
   * 
   */
  val timestamp : Double

) : pl.wendigo.chrome.DebuggerEvent(domain = "HeapProfiler", name = "lastSeenObjectId")

/**
 * Represents responseFrame from HeapProfiler. method call.
 *
 * If heap objects tracking has been started then backend may send update for one or more fragments
 */
data class HeapStatsUpdateEvent(
  /**
   * An array of triplets. Each triplet describes a fragment. The first integer is the fragment index, the second integer is a total count of objects for the fragment, the third integer is a total size of the objects for the fragment.
   */
  val statsUpdate : Array<Int>

) : pl.wendigo.chrome.DebuggerEvent(domain = "HeapProfiler", name = "heapStatsUpdate")


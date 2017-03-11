package pl.wendigo.chrome.domain.database

/**
 * DatabaseDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class DatabaseDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Enables database tracking, database events will now be delivered to the client.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Database.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables database tracking, prevents database events from being sent to the client.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Database.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun getDatabaseTableNames(input : GetDatabaseTableNamesRequest) : io.reactivex.Flowable<GetDatabaseTableNamesResponse> {
        return connection.runAndCaptureResponse("Database.getDatabaseTableNames", input, GetDatabaseTableNamesResponse::class.java)
	}

	/**
	 * 
	 */
	  fun executeSQL(input : ExecuteSQLRequest) : io.reactivex.Flowable<ExecuteSQLResponse> {
        return connection.runAndCaptureResponse("Database.executeSQL", input, ExecuteSQLResponse::class.java)
	}

  
  /**
   * 
   */
   fun addDatabase() : io.reactivex.Flowable<AddDatabaseEvent> {
      return connection.captureEvents("Database.addDatabase", AddDatabaseEvent::class.java)
   }
}





/**
 * Represents requestFrame parameters that can be used with Database.getDatabaseTableNames method call.
 *
 * 
 */
data class GetDatabaseTableNamesRequest (
    /**
     * 
     */
    val databaseId : DatabaseId

)

/**
 * Represents responseFrame from Database. method call.
 *
 * 
 */
data class GetDatabaseTableNamesResponse(
  /**
   * 
   */
  val tableNames : Array<String>

)

/**
 * Represents requestFrame parameters that can be used with Database.executeSQL method call.
 *
 * 
 */
data class ExecuteSQLRequest (
    /**
     * 
     */
    val databaseId : DatabaseId,

    /**
     * 
     */
    val query : String

)

/**
 * Represents responseFrame from Database. method call.
 *
 * 
 */
data class ExecuteSQLResponse(
  /**
   * 
   */
  val columnNames : Array<String>? = null,

  /**
   * 
   */
  val values : Array<Any>? = null,

  /**
   * 
   */
  val sqlError : Error? = null

)


/**
 * Represents responseFrame from Database. method call.
 *
 * 
 */
data class AddDatabaseEvent(
  /**
   * 
   */
  val database : Database

) : pl.wendigo.chrome.DebuggerEvent(domain = "Database", name = "addDatabase")


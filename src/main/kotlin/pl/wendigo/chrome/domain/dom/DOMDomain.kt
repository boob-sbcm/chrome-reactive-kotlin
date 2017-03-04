package pl.wendigo.chrome.domain.dom

/**
 * This domain exposes DOM read/write operations. Each DOM Node is represented with its mirror object that has an <code>id</code>. This <code>id</code> can be used to get additional information on the Node, resolve it into the JavaScript object wrapper, etc. It is important that client receives DOM events only for the nodes that are known to the client. Backend keeps track of the nodes that were sent to the client and never sends the same node twice. It is client's responsibility to collect information about the nodes that were sent to the client.<p>Note that <code>iframe</code> owner elements will return corresponding document elements as their child nodes.</p>
 *
 * This class was autogenerated by main.go. Do not edit :)
 */
class DOMDomain internal constructor(private val connection : pl.wendigo.chrome.RemoteChromeConnection) {

	/**
	 * Enables DOM agent for the given page.
	 */
	fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.enable", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Disables DOM agent for the given page.
	 */
	fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.disable", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Returns the root DOM node (and optionally the subtree) to the caller.
	 */
	fun getDocument(input : GetDocumentRequest) : io.reactivex.Flowable<GetDocumentResponse> {
        return connection.runAndCaptureResponse("$domainName.getDocument", input, GetDocumentResponse::class.java)
	}

	/**
	 * Collects class names for the node with given id and all of it's child nodes.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun collectClassNamesFromSubtree(input : CollectClassNamesFromSubtreeRequest) : io.reactivex.Flowable<CollectClassNamesFromSubtreeResponse> {
        return connection.runAndCaptureResponse("$domainName.collectClassNamesFromSubtree", input, CollectClassNamesFromSubtreeResponse::class.java)
	}

	/**
	 * Requests that children of the node with given id are returned to the caller in form of <code>setChildNodes</code> events where not only immediate children are retrieved, but all children down to the specified depth.
	 */
	fun requestChildNodes(input : RequestChildNodesRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.requestChildNodes", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Executes <code>querySelector</code> on a given node.
	 */
	fun querySelector(input : QuerySelectorRequest) : io.reactivex.Flowable<QuerySelectorResponse> {
        return connection.runAndCaptureResponse("$domainName.querySelector", input, QuerySelectorResponse::class.java)
	}

	/**
	 * Executes <code>querySelectorAll</code> on a given node.
	 */
	fun querySelectorAll(input : QuerySelectorAllRequest) : io.reactivex.Flowable<QuerySelectorAllResponse> {
        return connection.runAndCaptureResponse("$domainName.querySelectorAll", input, QuerySelectorAllResponse::class.java)
	}

	/**
	 * Sets node name for a node with given id.
	 */
	fun setNodeName(input : SetNodeNameRequest) : io.reactivex.Flowable<SetNodeNameResponse> {
        return connection.runAndCaptureResponse("$domainName.setNodeName", input, SetNodeNameResponse::class.java)
	}

	/**
	 * Sets node value for a node with given id.
	 */
	fun setNodeValue(input : SetNodeValueRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setNodeValue", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Removes node with given id.
	 */
	fun removeNode(input : RemoveNodeRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.removeNode", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Sets attribute for an element with given id.
	 */
	fun setAttributeValue(input : SetAttributeValueRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setAttributeValue", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Sets attributes on element with given id. This method is useful when user edits some existing attribute value and types in several attribute name/value pairs.
	 */
	fun setAttributesAsText(input : SetAttributesAsTextRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setAttributesAsText", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Removes attribute with given name from an element with given id.
	 */
	fun removeAttribute(input : RemoveAttributeRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.removeAttribute", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Returns node's HTML markup.
	 */
	fun getOuterHTML(input : GetOuterHTMLRequest) : io.reactivex.Flowable<GetOuterHTMLResponse> {
        return connection.runAndCaptureResponse("$domainName.getOuterHTML", input, GetOuterHTMLResponse::class.java)
	}

	/**
	 * Sets node HTML markup, returns new node id.
	 */
	fun setOuterHTML(input : SetOuterHTMLRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setOuterHTML", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Searches for a given string in the DOM tree. Use <code>getSearchResults</code> to access search results or <code>cancelSearch</code> to end this search session.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun performSearch(input : PerformSearchRequest) : io.reactivex.Flowable<PerformSearchResponse> {
        return connection.runAndCaptureResponse("$domainName.performSearch", input, PerformSearchResponse::class.java)
	}

	/**
	 * Returns search results from given <code>fromIndex</code> to given <code>toIndex</code> from the sarch with the given identifier.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun getSearchResults(input : GetSearchResultsRequest) : io.reactivex.Flowable<GetSearchResultsResponse> {
        return connection.runAndCaptureResponse("$domainName.getSearchResults", input, GetSearchResultsResponse::class.java)
	}

	/**
	 * Discards search results from the session with the given id. <code>getSearchResults</code> should no longer be called for that search.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun discardSearchResults(input : DiscardSearchResultsRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.discardSearchResults", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Requests that the node is sent to the caller given the JavaScript node object reference. All nodes that form the path from the node to the root are also sent to the client as a series of <code>setChildNodes</code> notifications.
	 */
	fun requestNode(input : RequestNodeRequest) : io.reactivex.Flowable<RequestNodeResponse> {
        return connection.runAndCaptureResponse("$domainName.requestNode", input, RequestNodeResponse::class.java)
	}

	/**
	 * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted. Backend then generates 'inspectNodeRequested' event upon element selection.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun setInspectMode(input : SetInspectModeRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setInspectMode", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
	 */
	fun highlightRect(input : HighlightRectRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.highlightRect", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun highlightQuad(input : HighlightQuadRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.highlightQuad", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
	 */
	fun highlightNode(input : HighlightNodeRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.highlightNode", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Hides DOM node highlight.
	 */
	fun hideHighlight() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.hideHighlight", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Highlights owner element of the frame with given id.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun highlightFrame(input : HighlightFrameRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.highlightFrame", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Requests that the node is sent to the caller given its path. // FIXME, use XPath
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun pushNodeByPathToFrontend(input : PushNodeByPathToFrontendRequest) : io.reactivex.Flowable<PushNodeByPathToFrontendResponse> {
        return connection.runAndCaptureResponse("$domainName.pushNodeByPathToFrontend", input, PushNodeByPathToFrontendResponse::class.java)
	}

	/**
	 * Requests that a batch of nodes is sent to the caller given their backend node ids.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun pushNodesByBackendIdsToFrontend(input : PushNodesByBackendIdsToFrontendRequest) : io.reactivex.Flowable<PushNodesByBackendIdsToFrontendResponse> {
        return connection.runAndCaptureResponse("$domainName.pushNodesByBackendIdsToFrontend", input, PushNodesByBackendIdsToFrontendResponse::class.java)
	}

	/**
	 * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun setInspectedNode(input : SetInspectedNodeRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setInspectedNode", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Resolves JavaScript node object for given node id.
	 */
	fun resolveNode(input : ResolveNodeRequest) : io.reactivex.Flowable<ResolveNodeResponse> {
        return connection.runAndCaptureResponse("$domainName.resolveNode", input, ResolveNodeResponse::class.java)
	}

	/**
	 * Returns attributes for the specified node.
	 */
	fun getAttributes(input : GetAttributesRequest) : io.reactivex.Flowable<GetAttributesResponse> {
        return connection.runAndCaptureResponse("$domainName.getAttributes", input, GetAttributesResponse::class.java)
	}

	/**
	 * Creates a deep copy of the specified node and places it into the target container before the given anchor.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun copyTo(input : CopyToRequest) : io.reactivex.Flowable<CopyToResponse> {
        return connection.runAndCaptureResponse("$domainName.copyTo", input, CopyToResponse::class.java)
	}

	/**
	 * Moves node into the new container, places it before the given anchor.
	 */
	fun moveTo(input : MoveToRequest) : io.reactivex.Flowable<MoveToResponse> {
        return connection.runAndCaptureResponse("$domainName.moveTo", input, MoveToResponse::class.java)
	}

	/**
	 * Undoes the last performed action.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun undo() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.undo", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Re-does the last undone action.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun redo() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.redo", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Marks last undoable state.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun markUndoableState() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.markUndoableState", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Focuses the given element.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun focus(input : FocusRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.focus", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Sets files for the given file input element.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun setFileInputFiles(input : SetFileInputFilesRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setFileInputFiles", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Returns boxes for the currently selected nodes.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun getBoxModel(input : GetBoxModelRequest) : io.reactivex.Flowable<GetBoxModelResponse> {
        return connection.runAndCaptureResponse("$domainName.getBoxModel", input, GetBoxModelResponse::class.java)
	}

	/**
	 * Returns node id at given location.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun getNodeForLocation(input : GetNodeForLocationRequest) : io.reactivex.Flowable<GetNodeForLocationResponse> {
        return connection.runAndCaptureResponse("$domainName.getNodeForLocation", input, GetNodeForLocationResponse::class.java)
	}

	/**
	 * Returns the id of the nearest ancestor that is a relayout boundary.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun getRelayoutBoundary(input : GetRelayoutBoundaryRequest) : io.reactivex.Flowable<GetRelayoutBoundaryResponse> {
        return connection.runAndCaptureResponse("$domainName.getRelayoutBoundary", input, GetRelayoutBoundaryResponse::class.java)
	}

	/**
	 * For testing.
	 */
	@pl.wendigo.chrome.ProtocolExperimental fun getHighlightObjectForTest(input : GetHighlightObjectForTestRequest) : io.reactivex.Flowable<GetHighlightObjectForTestResponse> {
        return connection.runAndCaptureResponse("$domainName.getHighlightObjectForTest", input, GetHighlightObjectForTestResponse::class.java)
	}

  /**
   * Fired when <code>Document</code> has been totally updated. Node ids are no longer valid.
   */
  fun onDocumentUpdated() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
      return connection.captureEvents("$domainName.documentUpdated", pl.wendigo.chrome.GenericResponse::class.java)
  }

  /**
   * Fired when the node should be inspected. This happens after call to <code>setInspectMode</code>.
   */
  fun onInspectNodeRequested() : io.reactivex.Flowable<InspectNodeRequestedEvent> {
      return connection.captureEvents("$domainName.inspectNodeRequested", InspectNodeRequestedEvent::class.java)
  }

  /**
   * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
   */
  fun onSetChildNodes() : io.reactivex.Flowable<SetChildNodesEvent> {
      return connection.captureEvents("$domainName.setChildNodes", SetChildNodesEvent::class.java)
  }

  /**
   * Fired when <code>Element</code>'s attribute is modified.
   */
  fun onAttributeModified() : io.reactivex.Flowable<AttributeModifiedEvent> {
      return connection.captureEvents("$domainName.attributeModified", AttributeModifiedEvent::class.java)
  }

  /**
   * Fired when <code>Element</code>'s attribute is removed.
   */
  fun onAttributeRemoved() : io.reactivex.Flowable<AttributeRemovedEvent> {
      return connection.captureEvents("$domainName.attributeRemoved", AttributeRemovedEvent::class.java)
  }

  /**
   * Fired when <code>Element</code>'s inline style is modified via a CSS property modification.
   */
  fun onInlineStyleInvalidated() : io.reactivex.Flowable<InlineStyleInvalidatedEvent> {
      return connection.captureEvents("$domainName.inlineStyleInvalidated", InlineStyleInvalidatedEvent::class.java)
  }

  /**
   * Mirrors <code>DOMCharacterDataModified</code> event.
   */
  fun onCharacterDataModified() : io.reactivex.Flowable<CharacterDataModifiedEvent> {
      return connection.captureEvents("$domainName.characterDataModified", CharacterDataModifiedEvent::class.java)
  }

  /**
   * Fired when <code>Container</code>'s child node count has changed.
   */
  fun onChildNodeCountUpdated() : io.reactivex.Flowable<ChildNodeCountUpdatedEvent> {
      return connection.captureEvents("$domainName.childNodeCountUpdated", ChildNodeCountUpdatedEvent::class.java)
  }

  /**
   * Mirrors <code>DOMNodeInserted</code> event.
   */
  fun onChildNodeInserted() : io.reactivex.Flowable<ChildNodeInsertedEvent> {
      return connection.captureEvents("$domainName.childNodeInserted", ChildNodeInsertedEvent::class.java)
  }

  /**
   * Mirrors <code>DOMNodeRemoved</code> event.
   */
  fun onChildNodeRemoved() : io.reactivex.Flowable<ChildNodeRemovedEvent> {
      return connection.captureEvents("$domainName.childNodeRemoved", ChildNodeRemovedEvent::class.java)
  }

  /**
   * Called when shadow root is pushed into the element.
   */
  fun onShadowRootPushed() : io.reactivex.Flowable<ShadowRootPushedEvent> {
      return connection.captureEvents("$domainName.shadowRootPushed", ShadowRootPushedEvent::class.java)
  }

  /**
   * Called when shadow root is popped from the element.
   */
  fun onShadowRootPopped() : io.reactivex.Flowable<ShadowRootPoppedEvent> {
      return connection.captureEvents("$domainName.shadowRootPopped", ShadowRootPoppedEvent::class.java)
  }

  /**
   * Called when a pseudo element is added to an element.
   */
  fun onPseudoElementAdded() : io.reactivex.Flowable<PseudoElementAddedEvent> {
      return connection.captureEvents("$domainName.pseudoElementAdded", PseudoElementAddedEvent::class.java)
  }

  /**
   * Called when a pseudo element is removed from an element.
   */
  fun onPseudoElementRemoved() : io.reactivex.Flowable<PseudoElementRemovedEvent> {
      return connection.captureEvents("$domainName.pseudoElementRemoved", PseudoElementRemovedEvent::class.java)
  }

  /**
   * Called when distrubution is changed.
   */
  fun onDistributedNodesUpdated() : io.reactivex.Flowable<DistributedNodesUpdatedEvent> {
      return connection.captureEvents("$domainName.distributedNodesUpdated", DistributedNodesUpdatedEvent::class.java)
  }

  /**
   *
   */
  fun onNodeHighlightRequested() : io.reactivex.Flowable<NodeHighlightRequestedEvent> {
      return connection.captureEvents("$domainName.nodeHighlightRequested", NodeHighlightRequestedEvent::class.java)
  }

  companion object {
    private const val domainName = "DOM"
  }
}

data class GetDocumentRequest (
    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
     */
    @pl.wendigo.chrome.ProtocolExperimental val depth : Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
     */
    @pl.wendigo.chrome.ProtocolExperimental val pierce : Boolean? = null

)

data class GetDocumentResponse (
  /**
   * Resulting node.
   */
  val root : Node

)

data class CollectClassNamesFromSubtreeRequest (
    /**
     * Id of the node to collect class names.
     */
    val nodeId : NodeId

)

data class CollectClassNamesFromSubtreeResponse (
  /**
   * Class name list.
   */
  val classNames : Array<String>

)

data class RequestChildNodesRequest (
    /**
     * Id of the node to get children for.
     */
    val nodeId : NodeId,

    /**
     * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
     */
    @pl.wendigo.chrome.ProtocolExperimental val depth : Int? = null,

    /**
     * Whether or not iframes and shadow roots should be traversed when returning the sub-tree (default is false).
     */
    @pl.wendigo.chrome.ProtocolExperimental val pierce : Boolean? = null

)

data class QuerySelectorRequest (
    /**
     * Id of the node to query upon.
     */
    val nodeId : NodeId,

    /**
     * Selector string.
     */
    val selector : String

)

data class QuerySelectorResponse (
  /**
   * Query selector result.
   */
  val nodeId : NodeId

)

data class QuerySelectorAllRequest (
    /**
     * Id of the node to query upon.
     */
    val nodeId : NodeId,

    /**
     * Selector string.
     */
    val selector : String

)

data class QuerySelectorAllResponse (
  /**
   * Query selector result.
   */
  val nodeIds : Array<NodeId>

)

data class SetNodeNameRequest (
    /**
     * Id of the node to set name for.
     */
    val nodeId : NodeId,

    /**
     * New node's name.
     */
    val name : String

)

data class SetNodeNameResponse (
  /**
   * New node's id.
   */
  val nodeId : NodeId

)

data class SetNodeValueRequest (
    /**
     * Id of the node to set value for.
     */
    val nodeId : NodeId,

    /**
     * New node's value.
     */
    val value : String

)

data class RemoveNodeRequest (
    /**
     * Id of the node to remove.
     */
    val nodeId : NodeId

)

data class SetAttributeValueRequest (
    /**
     * Id of the element to set attribute for.
     */
    val nodeId : NodeId,

    /**
     * Attribute name.
     */
    val name : String,

    /**
     * Attribute value.
     */
    val value : String

)

data class SetAttributesAsTextRequest (
    /**
     * Id of the element to set attributes for.
     */
    val nodeId : NodeId,

    /**
     * Text with a number of attributes. Will parse this text using HTML parser.
     */
    val text : String,

    /**
     * Attribute name to replace with new attributes derived from text in case text parsed successfully.
     */
    val name : String? = null

)

data class RemoveAttributeRequest (
    /**
     * Id of the element to remove attribute from.
     */
    val nodeId : NodeId,

    /**
     * Name of the attribute to remove.
     */
    val name : String

)

data class GetOuterHTMLRequest (
    /**
     * Id of the node to get markup for.
     */
    val nodeId : NodeId

)

data class GetOuterHTMLResponse (
  /**
   * Outer HTML markup.
   */
  val outerHTML : String

)

data class SetOuterHTMLRequest (
    /**
     * Id of the node to set markup for.
     */
    val nodeId : NodeId,

    /**
     * Outer HTML markup to set.
     */
    val outerHTML : String

)

data class PerformSearchRequest (
    /**
     * Plain text or query selector or XPath search query.
     */
    val query : String,

    /**
     * True to search in user agent shadow DOM.
     */
    @pl.wendigo.chrome.ProtocolExperimental val includeUserAgentShadowDOM : Boolean? = null

)

data class PerformSearchResponse (
  /**
   * Unique search session identifier.
   */
  val searchId : String,

  /**
   * Number of search results.
   */
  val resultCount : Int

)

data class GetSearchResultsRequest (
    /**
     * Unique search session identifier.
     */
    val searchId : String,

    /**
     * Start index of the search result to be returned.
     */
    val fromIndex : Int,

    /**
     * End index of the search result to be returned.
     */
    val toIndex : Int

)

data class GetSearchResultsResponse (
  /**
   * Ids of the search result nodes.
   */
  val nodeIds : Array<NodeId>

)

data class DiscardSearchResultsRequest (
    /**
     * Unique search session identifier.
     */
    val searchId : String

)

data class RequestNodeRequest (
    /**
     * JavaScript object id to convert into node.
     */
    val objectId : pl.wendigo.chrome.domain.runtime.RemoteObjectId

)

data class RequestNodeResponse (
  /**
   * Node id for given object.
   */
  val nodeId : NodeId

)

data class SetInspectModeRequest (
    /**
     * Set an inspection mode.
     */
    val mode : InspectMode,

    /**
     * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if <code>enabled == false</code>.
     */
    val highlightConfig : HighlightConfig? = null

)

data class HighlightRectRequest (
    /**
     * X coordinate
     */
    val x : Int,

    /**
     * Y coordinate
     */
    val y : Int,

    /**
     * Rectangle width
     */
    val width : Int,

    /**
     * Rectangle height
     */
    val height : Int,

    /**
     * The highlight fill color (default: transparent).
     */
    val color : RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor : RGBA? = null

)

data class HighlightQuadRequest (
    /**
     * Quad to highlight
     */
    val quad : Quad,

    /**
     * The highlight fill color (default: transparent).
     */
    val color : RGBA? = null,

    /**
     * The highlight outline color (default: transparent).
     */
    val outlineColor : RGBA? = null

)

data class HighlightNodeRequest (
    /**
     * A descriptor for the highlight appearance.
     */
    val highlightConfig : HighlightConfig,

    /**
     * Identifier of the node to highlight.
     */
    val nodeId : NodeId? = null,

    /**
     * Identifier of the backend node to highlight.
     */
    val backendNodeId : BackendNodeId? = null,

    /**
     * JavaScript object id of the node to be highlighted.
     */
    @pl.wendigo.chrome.ProtocolExperimental val objectId : pl.wendigo.chrome.domain.runtime.RemoteObjectId? = null

)

data class HighlightFrameRequest (
    /**
     * Identifier of the frame to highlight.
     */
    val frameId : pl.wendigo.chrome.domain.page.FrameId,

    /**
     * The content box highlight fill color (default: transparent).
     */
    val contentColor : RGBA? = null,

    /**
     * The content box highlight outline color (default: transparent).
     */
    val contentOutlineColor : RGBA? = null

)

data class PushNodeByPathToFrontendRequest (
    /**
     * Path to node in the proprietary format.
     */
    val path : String

)

data class PushNodeByPathToFrontendResponse (
  /**
   * Id of the node for given path.
   */
  val nodeId : NodeId

)

data class PushNodesByBackendIdsToFrontendRequest (
    /**
     * The array of backend node ids.
     */
    val backendNodeIds : Array<BackendNodeId>

)

data class PushNodesByBackendIdsToFrontendResponse (
  /**
   * The array of ids of pushed nodes that correspond to the backend ids specified in backendNodeIds.
   */
  val nodeIds : Array<NodeId>

)

data class SetInspectedNodeRequest (
    /**
     * DOM node id to be accessible by means of $x command line API.
     */
    val nodeId : NodeId

)

data class ResolveNodeRequest (
    /**
     * Id of the node to resolve.
     */
    val nodeId : NodeId,

    /**
     * Symbolic group name that can be used to release multiple objects.
     */
    val objectGroup : String? = null

)

data class ResolveNodeResponse (
  /**
   * JavaScript object wrapper for given node.
   */
  @get:com.fasterxml.jackson.annotation.JsonProperty("object") val _object : pl.wendigo.chrome.domain.runtime.RemoteObject

)

data class GetAttributesRequest (
    /**
     * Id of the node to retrieve attibutes for.
     */
    val nodeId : NodeId

)

data class GetAttributesResponse (
  /**
   * An interleaved array of node attribute names and values.
   */
  val attributes : Array<String>

)

data class CopyToRequest (
    /**
     * Id of the node to copy.
     */
    val nodeId : NodeId,

    /**
     * Id of the element to drop the copy into.
     */
    val targetNodeId : NodeId,

    /**
     * Drop the copy before this node (if absent, the copy becomes the last child of <code>targetNodeId</code>).
     */
    val insertBeforeNodeId : NodeId? = null

)

data class CopyToResponse (
  /**
   * Id of the node clone.
   */
  val nodeId : NodeId

)

data class MoveToRequest (
    /**
     * Id of the node to move.
     */
    val nodeId : NodeId,

    /**
     * Id of the element to drop the moved node into.
     */
    val targetNodeId : NodeId,

    /**
     * Drop node before this one (if absent, the moved node becomes the last child of <code>targetNodeId</code>).
     */
    val insertBeforeNodeId : NodeId? = null

)

data class MoveToResponse (
  /**
   * New id of the moved node.
   */
  val nodeId : NodeId

)

data class FocusRequest (
    /**
     * Id of the node to focus.
     */
    val nodeId : NodeId

)

data class SetFileInputFilesRequest (
    /**
     * Id of the file input node to set files for.
     */
    val nodeId : NodeId,

    /**
     * Array of file paths to set.
     */
    val files : Array<String>

)

data class GetBoxModelRequest (
    /**
     * Id of the node to get box model for.
     */
    val nodeId : NodeId

)

data class GetBoxModelResponse (
  /**
   * Box model for the node.
   */
  val model : BoxModel

)

data class GetNodeForLocationRequest (
    /**
     * X coordinate.
     */
    val x : Int,

    /**
     * Y coordinate.
     */
    val y : Int

)

data class GetNodeForLocationResponse (
  /**
   * Id of the node at given coordinates.
   */
  val nodeId : NodeId

)

data class GetRelayoutBoundaryRequest (
    /**
     * Id of the node.
     */
    val nodeId : NodeId

)

data class GetRelayoutBoundaryResponse (
  /**
   * Relayout boundary node id for the given node.
   */
  val nodeId : NodeId

)

data class GetHighlightObjectForTestRequest (
    /**
     * Id of the node to get highlight object for.
     */
    val nodeId : NodeId

)

data class GetHighlightObjectForTestResponse (
  /**
   * Highlight data for the node.
   */
  val highlight : String

)

data class InspectNodeRequestedEvent (
  /**
   * Id of the node to inspect.
   */
  val backendNodeId : BackendNodeId

)

data class SetChildNodesEvent (
  /**
   * Parent node id to populate with children.
   */
  val parentId : NodeId,

  /**
   * Child nodes array.
   */
  val nodes : Array<Node>

)

data class AttributeModifiedEvent (
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * Attribute name.
   */
  val name : String,

  /**
   * Attribute value.
   */
  val value : String

)

data class AttributeRemovedEvent (
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * A ttribute name.
   */
  val name : String

)

data class InlineStyleInvalidatedEvent (
  /**
   * Ids of the nodes for which the inline styles have been invalidated.
   */
  val nodeIds : Array<NodeId>

)

data class CharacterDataModifiedEvent (
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * New text value.
   */
  val characterData : String

)

data class ChildNodeCountUpdatedEvent (
  /**
   * Id of the node that has changed.
   */
  val nodeId : NodeId,

  /**
   * New node count.
   */
  val childNodeCount : Int

)

data class ChildNodeInsertedEvent (
  /**
   * Id of the node that has changed.
   */
  val parentNodeId : NodeId,

  /**
   * If of the previous siblint.
   */
  val previousNodeId : NodeId,

  /**
   * Inserted node data.
   */
  val node : Node

)

data class ChildNodeRemovedEvent (
  /**
   * Parent id.
   */
  val parentNodeId : NodeId,

  /**
   * Id of the node that has been removed.
   */
  val nodeId : NodeId

)

data class ShadowRootPushedEvent (
  /**
   * Host element id.
   */
  val hostId : NodeId,

  /**
   * Shadow root.
   */
  val root : Node

)

data class ShadowRootPoppedEvent (
  /**
   * Host element id.
   */
  val hostId : NodeId,

  /**
   * Shadow root id.
   */
  val rootId : NodeId

)

data class PseudoElementAddedEvent (
  /**
   * Pseudo element's parent element id.
   */
  val parentId : NodeId,

  /**
   * The added pseudo element.
   */
  val pseudoElement : Node

)

data class PseudoElementRemovedEvent (
  /**
   * Pseudo element's parent element id.
   */
  val parentId : NodeId,

  /**
   * The removed pseudo element id.
   */
  val pseudoElementId : NodeId

)

data class DistributedNodesUpdatedEvent (
  /**
   * Insertion point where distrubuted nodes were updated.
   */
  val insertionPointId : NodeId,

  /**
   * Distributed nodes for given insertion point.
   */
  val distributedNodes : Array<BackendNode>

)

data class NodeHighlightRequestedEvent (
  /**
   *
   */
  val nodeId : NodeId

)


/*
 * Digitraffic Road API
 * [OpenAPI document](/swagger/openapi.json)   Digitraffic is a service operated by the [Fintraffic](https://www.fintraffic.fi) offering real time traffic information. Currently the service covers *road, marine and rail* traffic. More information can be found at the [Digitraffic website](https://www.digitraffic.fi/)   The service has a public Google-group [road.digitraffic.fi](https://groups.google.com/forum/#!forum/roaddigitrafficfi) for communication between developers, service administrators and Fintraffic. The discussion in the forum is mostly in Finnish, but you're welcome to communicate in English too.   ### General notes of the API * Many Digitraffic APIs use GeoJSON as data format. Definition of the GeoJSON format can be found at https://tools.ietf.org/html/rfc7946. * For dates and times [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format is used with \"Zulu\" zero offset from UTC unless otherwise specified (i.e., \"yyyy-mm-ddThh:mm:ss[.mmm]Z\"). E.g. 2019-11-01T06:30:00Z.
 *
 * The version of the OpenAPI document: 2.94.0#e017ffd@2022-10-18T07:48:28+0000
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package fi.tuni.monitor.roadapi.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import fi.tuni.monitor.roadapi.model.Document;
import fi.tuni.monitor.roadapi.model.NamedNodeMap;
import fi.tuni.monitor.roadapi.model.Node;
import fi.tuni.monitor.roadapi.model.NodeList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * DocumentType
 */
@JsonPropertyOrder({
  DocumentType.JSON_PROPERTY_NOTATIONS,
  DocumentType.JSON_PROPERTY_PUBLIC_ID,
  DocumentType.JSON_PROPERTY_SYSTEM_ID,
  DocumentType.JSON_PROPERTY_ENTITIES,
  DocumentType.JSON_PROPERTY_INTERNAL_SUBSET,
  DocumentType.JSON_PROPERTY_NAME,
  DocumentType.JSON_PROPERTY_NODE_NAME,
  DocumentType.JSON_PROPERTY_NODE_VALUE,
  DocumentType.JSON_PROPERTY_PARENT_NODE,
  DocumentType.JSON_PROPERTY_CHILD_NODES,
  DocumentType.JSON_PROPERTY_FIRST_CHILD,
  DocumentType.JSON_PROPERTY_LAST_CHILD,
  DocumentType.JSON_PROPERTY_PREVIOUS_SIBLING,
  DocumentType.JSON_PROPERTY_NEXT_SIBLING,
  DocumentType.JSON_PROPERTY_OWNER_DOCUMENT,
  DocumentType.JSON_PROPERTY_NAMESPACE_U_R_I,
  DocumentType.JSON_PROPERTY_LOCAL_NAME,
  DocumentType.JSON_PROPERTY_BASE_U_R_I,
  DocumentType.JSON_PROPERTY_TEXT_CONTENT,
  DocumentType.JSON_PROPERTY_PREFIX,
  DocumentType.JSON_PROPERTY_NODE_TYPE,
  DocumentType.JSON_PROPERTY_ATTRIBUTES
})
public class DocumentType {
  public static final String JSON_PROPERTY_NOTATIONS = "notations";
  private NamedNodeMap notations;

  public static final String JSON_PROPERTY_PUBLIC_ID = "publicId";
  private String publicId;

  public static final String JSON_PROPERTY_SYSTEM_ID = "systemId";
  private String systemId;

  public static final String JSON_PROPERTY_ENTITIES = "entities";
  private NamedNodeMap entities;

  public static final String JSON_PROPERTY_INTERNAL_SUBSET = "internalSubset";
  private String internalSubset;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_NODE_NAME = "nodeName";
  private String nodeName;

  public static final String JSON_PROPERTY_NODE_VALUE = "nodeValue";
  private String nodeValue;

  public static final String JSON_PROPERTY_PARENT_NODE = "parentNode";
  private Node parentNode;

  public static final String JSON_PROPERTY_CHILD_NODES = "childNodes";
  private NodeList childNodes;

  public static final String JSON_PROPERTY_FIRST_CHILD = "firstChild";
  private Node firstChild;

  public static final String JSON_PROPERTY_LAST_CHILD = "lastChild";
  private Node lastChild;

  public static final String JSON_PROPERTY_PREVIOUS_SIBLING = "previousSibling";
  private Node previousSibling;

  public static final String JSON_PROPERTY_NEXT_SIBLING = "nextSibling";
  private Node nextSibling;

  public static final String JSON_PROPERTY_OWNER_DOCUMENT = "ownerDocument";
  private Document ownerDocument;

  public static final String JSON_PROPERTY_NAMESPACE_U_R_I = "namespaceURI";
  private String namespaceURI;

  public static final String JSON_PROPERTY_LOCAL_NAME = "localName";
  private String localName;

  public static final String JSON_PROPERTY_BASE_U_R_I = "baseURI";
  private String baseURI;

  public static final String JSON_PROPERTY_TEXT_CONTENT = "textContent";
  private String textContent;

  public static final String JSON_PROPERTY_PREFIX = "prefix";
  private String prefix;

  public static final String JSON_PROPERTY_NODE_TYPE = "nodeType";
  private Integer nodeType;

  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private NamedNodeMap attributes;

  public DocumentType() {
  }

  public DocumentType notations(NamedNodeMap notations) {
    
    this.notations = notations;
    return this;
  }

   /**
   * Get notations
   * @return notations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NOTATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NamedNodeMap getNotations() {
    return notations;
  }


  @JsonProperty(JSON_PROPERTY_NOTATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotations(NamedNodeMap notations) {
    this.notations = notations;
  }


  public DocumentType publicId(String publicId) {
    
    this.publicId = publicId;
    return this;
  }

   /**
   * Get publicId
   * @return publicId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PUBLIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPublicId() {
    return publicId;
  }


  @JsonProperty(JSON_PROPERTY_PUBLIC_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPublicId(String publicId) {
    this.publicId = publicId;
  }


  public DocumentType systemId(String systemId) {
    
    this.systemId = systemId;
    return this;
  }

   /**
   * Get systemId
   * @return systemId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SYSTEM_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSystemId() {
    return systemId;
  }


  @JsonProperty(JSON_PROPERTY_SYSTEM_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }


  public DocumentType entities(NamedNodeMap entities) {
    
    this.entities = entities;
    return this;
  }

   /**
   * Get entities
   * @return entities
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NamedNodeMap getEntities() {
    return entities;
  }


  @JsonProperty(JSON_PROPERTY_ENTITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEntities(NamedNodeMap entities) {
    this.entities = entities;
  }


  public DocumentType internalSubset(String internalSubset) {
    
    this.internalSubset = internalSubset;
    return this;
  }

   /**
   * Get internalSubset
   * @return internalSubset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INTERNAL_SUBSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInternalSubset() {
    return internalSubset;
  }


  @JsonProperty(JSON_PROPERTY_INTERNAL_SUBSET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInternalSubset(String internalSubset) {
    this.internalSubset = internalSubset;
  }


  public DocumentType name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public DocumentType nodeName(String nodeName) {
    
    this.nodeName = nodeName;
    return this;
  }

   /**
   * Get nodeName
   * @return nodeName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NODE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNodeName() {
    return nodeName;
  }


  @JsonProperty(JSON_PROPERTY_NODE_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }


  public DocumentType nodeValue(String nodeValue) {
    
    this.nodeValue = nodeValue;
    return this;
  }

   /**
   * Get nodeValue
   * @return nodeValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NODE_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNodeValue() {
    return nodeValue;
  }


  @JsonProperty(JSON_PROPERTY_NODE_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNodeValue(String nodeValue) {
    this.nodeValue = nodeValue;
  }


  public DocumentType parentNode(Node parentNode) {
    
    this.parentNode = parentNode;
    return this;
  }

   /**
   * Get parentNode
   * @return parentNode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PARENT_NODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Node getParentNode() {
    return parentNode;
  }


  @JsonProperty(JSON_PROPERTY_PARENT_NODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setParentNode(Node parentNode) {
    this.parentNode = parentNode;
  }


  public DocumentType childNodes(NodeList childNodes) {
    
    this.childNodes = childNodes;
    return this;
  }

   /**
   * Get childNodes
   * @return childNodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CHILD_NODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NodeList getChildNodes() {
    return childNodes;
  }


  @JsonProperty(JSON_PROPERTY_CHILD_NODES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChildNodes(NodeList childNodes) {
    this.childNodes = childNodes;
  }


  public DocumentType firstChild(Node firstChild) {
    
    this.firstChild = firstChild;
    return this;
  }

   /**
   * Get firstChild
   * @return firstChild
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FIRST_CHILD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Node getFirstChild() {
    return firstChild;
  }


  @JsonProperty(JSON_PROPERTY_FIRST_CHILD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstChild(Node firstChild) {
    this.firstChild = firstChild;
  }


  public DocumentType lastChild(Node lastChild) {
    
    this.lastChild = lastChild;
    return this;
  }

   /**
   * Get lastChild
   * @return lastChild
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LAST_CHILD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Node getLastChild() {
    return lastChild;
  }


  @JsonProperty(JSON_PROPERTY_LAST_CHILD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastChild(Node lastChild) {
    this.lastChild = lastChild;
  }


  public DocumentType previousSibling(Node previousSibling) {
    
    this.previousSibling = previousSibling;
    return this;
  }

   /**
   * Get previousSibling
   * @return previousSibling
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PREVIOUS_SIBLING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Node getPreviousSibling() {
    return previousSibling;
  }


  @JsonProperty(JSON_PROPERTY_PREVIOUS_SIBLING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPreviousSibling(Node previousSibling) {
    this.previousSibling = previousSibling;
  }


  public DocumentType nextSibling(Node nextSibling) {
    
    this.nextSibling = nextSibling;
    return this;
  }

   /**
   * Get nextSibling
   * @return nextSibling
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NEXT_SIBLING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Node getNextSibling() {
    return nextSibling;
  }


  @JsonProperty(JSON_PROPERTY_NEXT_SIBLING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNextSibling(Node nextSibling) {
    this.nextSibling = nextSibling;
  }


  public DocumentType ownerDocument(Document ownerDocument) {
    
    this.ownerDocument = ownerDocument;
    return this;
  }

   /**
   * Get ownerDocument
   * @return ownerDocument
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OWNER_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Document getOwnerDocument() {
    return ownerDocument;
  }


  @JsonProperty(JSON_PROPERTY_OWNER_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOwnerDocument(Document ownerDocument) {
    this.ownerDocument = ownerDocument;
  }


  public DocumentType namespaceURI(String namespaceURI) {
    
    this.namespaceURI = namespaceURI;
    return this;
  }

   /**
   * Get namespaceURI
   * @return namespaceURI
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NAMESPACE_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNamespaceURI() {
    return namespaceURI;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaceURI(String namespaceURI) {
    this.namespaceURI = namespaceURI;
  }


  public DocumentType localName(String localName) {
    
    this.localName = localName;
    return this;
  }

   /**
   * Get localName
   * @return localName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LOCAL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLocalName() {
    return localName;
  }


  @JsonProperty(JSON_PROPERTY_LOCAL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocalName(String localName) {
    this.localName = localName;
  }


  public DocumentType baseURI(String baseURI) {
    
    this.baseURI = baseURI;
    return this;
  }

   /**
   * Get baseURI
   * @return baseURI
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_BASE_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBaseURI() {
    return baseURI;
  }


  @JsonProperty(JSON_PROPERTY_BASE_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBaseURI(String baseURI) {
    this.baseURI = baseURI;
  }


  public DocumentType textContent(String textContent) {
    
    this.textContent = textContent;
    return this;
  }

   /**
   * Get textContent
   * @return textContent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TEXT_CONTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTextContent() {
    return textContent;
  }


  @JsonProperty(JSON_PROPERTY_TEXT_CONTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }


  public DocumentType prefix(String prefix) {
    
    this.prefix = prefix;
    return this;
  }

   /**
   * Get prefix
   * @return prefix
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PREFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPrefix() {
    return prefix;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }


  public DocumentType nodeType(Integer nodeType) {
    
    this.nodeType = nodeType;
    return this;
  }

   /**
   * Get nodeType
   * @return nodeType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NODE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNodeType() {
    return nodeType;
  }


  @JsonProperty(JSON_PROPERTY_NODE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNodeType(Integer nodeType) {
    this.nodeType = nodeType;
  }


  public DocumentType attributes(NamedNodeMap attributes) {
    
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NamedNodeMap getAttributes() {
    return attributes;
  }


  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttributes(NamedNodeMap attributes) {
    this.attributes = attributes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentType documentType = (DocumentType) o;
    return Objects.equals(this.notations, documentType.notations) &&
        Objects.equals(this.publicId, documentType.publicId) &&
        Objects.equals(this.systemId, documentType.systemId) &&
        Objects.equals(this.entities, documentType.entities) &&
        Objects.equals(this.internalSubset, documentType.internalSubset) &&
        Objects.equals(this.name, documentType.name) &&
        Objects.equals(this.nodeName, documentType.nodeName) &&
        Objects.equals(this.nodeValue, documentType.nodeValue) &&
        Objects.equals(this.parentNode, documentType.parentNode) &&
        Objects.equals(this.childNodes, documentType.childNodes) &&
        Objects.equals(this.firstChild, documentType.firstChild) &&
        Objects.equals(this.lastChild, documentType.lastChild) &&
        Objects.equals(this.previousSibling, documentType.previousSibling) &&
        Objects.equals(this.nextSibling, documentType.nextSibling) &&
        Objects.equals(this.ownerDocument, documentType.ownerDocument) &&
        Objects.equals(this.namespaceURI, documentType.namespaceURI) &&
        Objects.equals(this.localName, documentType.localName) &&
        Objects.equals(this.baseURI, documentType.baseURI) &&
        Objects.equals(this.textContent, documentType.textContent) &&
        Objects.equals(this.prefix, documentType.prefix) &&
        Objects.equals(this.nodeType, documentType.nodeType) &&
        Objects.equals(this.attributes, documentType.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notations, publicId, systemId, entities, internalSubset, name, nodeName, nodeValue, parentNode, childNodes, firstChild, lastChild, previousSibling, nextSibling, ownerDocument, namespaceURI, localName, baseURI, textContent, prefix, nodeType, attributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentType {\n");
    sb.append("    notations: ").append(toIndentedString(notations)).append("\n");
    sb.append("    publicId: ").append(toIndentedString(publicId)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
    sb.append("    entities: ").append(toIndentedString(entities)).append("\n");
    sb.append("    internalSubset: ").append(toIndentedString(internalSubset)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
    sb.append("    nodeValue: ").append(toIndentedString(nodeValue)).append("\n");
    sb.append("    parentNode: ").append(toIndentedString(parentNode)).append("\n");
    sb.append("    childNodes: ").append(toIndentedString(childNodes)).append("\n");
    sb.append("    firstChild: ").append(toIndentedString(firstChild)).append("\n");
    sb.append("    lastChild: ").append(toIndentedString(lastChild)).append("\n");
    sb.append("    previousSibling: ").append(toIndentedString(previousSibling)).append("\n");
    sb.append("    nextSibling: ").append(toIndentedString(nextSibling)).append("\n");
    sb.append("    ownerDocument: ").append(toIndentedString(ownerDocument)).append("\n");
    sb.append("    namespaceURI: ").append(toIndentedString(namespaceURI)).append("\n");
    sb.append("    localName: ").append(toIndentedString(localName)).append("\n");
    sb.append("    baseURI: ").append(toIndentedString(baseURI)).append("\n");
    sb.append("    textContent: ").append(toIndentedString(textContent)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


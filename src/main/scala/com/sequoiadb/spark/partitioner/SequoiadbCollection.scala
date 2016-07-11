/*
 *  Licensed to SequoiaDB (C) under one or more contributor license agreements.
 *  See the NOTICE file distributed with this work for additional information
 *  regarding copyright ownership. The SequoiaDB (C) licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.sequoiadb.spark.partitioner


/**
 * Source File Name = SequoiadbCollection.scala
 * Description      = Collection information SequoiaDB
 * When/how to use  = SequoiadbCollection is used to represent collection name
 * Restrictions     = N/A
 * Change Activity:
 * Date     Who                Description
 * ======== ================== ================================================
 * 20150305 Tao Wang           Initial Draft
 */


import org.bson.types.BasicBSONList

/**
 * SequoiaDB collection information
 * @param collectionspace Collection Space name
 * @param collection Collection name
 */
case class SequoiadbCollection (
    collectionspace: String,
    collection: String ) extends Serializable {
  /**
   * Retrieve full collection name
   */
  val collectionname = collectionspace + "." + collection
}

object SequoiadbCollection {
  /**
   * Build collection object by providing full string name (cs.cl)
   */
  def apply ( collectionname: String ) = {
    val cl = collectionname.split('.')
    new SequoiadbCollection(cl(0), if ( cl.length > 1 ) cl(1) else "")
  }
}
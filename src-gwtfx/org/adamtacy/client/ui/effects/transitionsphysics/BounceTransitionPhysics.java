/*
 * Copyright 2008-2009 Adam Tacy <adam.tacy AT gmail.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.adamtacy.client.ui.effects.transitionsphysics;

/**
 * Implements a Bounce style transition Physics.
 * 
 * This is a simple class that extends the elastic transition physics, and creates a bounce by 
 * inverting the result if the value is over 1,0.
 * 
 * @author Adam Tacy
 * @version 3.0
 * 
 */
public class BounceTransitionPhysics extends ElasticTransitionPhysics {
  
  /**
   * If the result is over 1.0 from the Elastic Transition Physics, then instead of letting the
   * value go past the end point, we invert it - effectively creating a bounce...
   */
  protected double guardResult(double input){
    if(input>1.0) input = 2.0-input;
    return input;
  }
}

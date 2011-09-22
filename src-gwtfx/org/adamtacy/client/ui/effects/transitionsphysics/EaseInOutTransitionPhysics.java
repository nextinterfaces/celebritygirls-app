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
 * A simple EaseInOut transition physics.  The transition starts of slowly, accelerates, and then slows down at the end
 * 
 * @author Adam Tacy
 * @version 3.0
 *
 */
public class EaseInOutTransitionPhysics extends EaseBase implements TransitionPhysics {

  /**
   * Formula is based on co-sin graph; there is no application of a dampening factor
   * for this transition.
   */
  public double applyTransitionPhysics(double input) {
    return ((-Math.cos(input * Math.PI) / 2) + 0.5);
  }

}

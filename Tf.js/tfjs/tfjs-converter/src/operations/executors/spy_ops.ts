/**
 * @license
 * Copyright 2022 Google LLC. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =============================================================================
 */

export type RecursiveSpy<T> =
    T extends Function ? jasmine.Spy : {[K in keyof T]: RecursiveSpy<T[K]>};

export function spyOnAllFunctions<T>(obj: T): RecursiveSpy<T> {
  return Object.fromEntries(Object.entries(obj).map(([key, val]) => {
    if (val instanceof Function) {
      return [key, jasmine.createSpy(`${key} spy`, val).and.callThrough()];
    } else if (val instanceof Array) {
      return [key, val];
    } else if (val instanceof Object) {
      return [key, spyOnAllFunctions(val)];
    }
    return [key, val];
  })) as RecursiveSpy<T>;
}

/**
 * @license
 * Copyright 2021 Google LLC. All Rights Reserved.
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

import {KernelConfig, KernelFunc, StringToHashBucketFast, StringToHashBucketFastAttrs, StringToHashBucketFastInputs, TensorInfo} from '@tensorflow/tfjs-core';

import {BackendWasm} from '../backend_wasm';
import {stringToHashBucketFastImplCPU} from '../kernel_utils/shared';

function stringToHashBucketFast(args: {
  backend: BackendWasm,
  inputs: StringToHashBucketFastInputs,
  attrs: StringToHashBucketFastAttrs
}): TensorInfo {
  const {backend, inputs, attrs} = args;
  const {input} = inputs;
  const {numBuckets} = attrs;

  const inputVals = backend.readSync(input.dataId) as Uint8Array[];

  const values = stringToHashBucketFastImplCPU(inputVals, numBuckets);

  const out = backend.makeOutput(input.shape, 'int32');
  const outVals = backend.typedArrayFromHeap(out);
  outVals.set(values);
  return out;
}

export const stringToHashBucketFastConfig: KernelConfig = {
  kernelName: StringToHashBucketFast,
  backendName: 'wasm',
  kernelFunc: stringToHashBucketFast as {} as KernelFunc
};

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

import {Cumprod, CumprodAttrs, CumprodInputs, KernelConfig, scalar} from '@tensorflow/tfjs';

import {createTensorsTypeOpAttr, NodeJSKernelBackend} from '../nodejs_kernel_backend';

export const cumprodConfig: KernelConfig = {
  kernelName: Cumprod,
  backendName: 'tensorflow',
  kernelFunc: (args) => {
    const {x} = args.inputs as CumprodInputs;
    const backend = args.backend as NodeJSKernelBackend;
    const {axis, exclusive, reverse} = args.attrs as {} as CumprodAttrs;

    const axisTensor = scalar(axis, 'int32');
    const opAttrs = [
      {name: 'exclusive', type: backend.binding.TF_ATTR_BOOL, value: exclusive},
      {name: 'reverse', type: backend.binding.TF_ATTR_BOOL, value: reverse},
      createTensorsTypeOpAttr('T', x.dtype),
      createTensorsTypeOpAttr('Tidx', 'int32')
    ];
    const res = backend.executeSingleOutput(Cumprod, opAttrs, [x, axisTensor]);
    axisTensor.dispose();
    return res;
  }
};

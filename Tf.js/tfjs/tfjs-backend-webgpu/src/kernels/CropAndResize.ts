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

import {CropAndResize, CropAndResizeAttrs, CropAndResizeInputs, KernelConfig, KernelFunc, TensorInfo} from '@tensorflow/tfjs-core';

import {WebGPUBackend} from '../backend_webgpu';
import {CropAndResizeProgram} from '../crop_and_resize_webgpu';

export const cropAndResize = (args: {
  inputs: CropAndResizeInputs,
  backend: WebGPUBackend,
  attrs: CropAndResizeAttrs
}): TensorInfo => {
  const {inputs, backend, attrs} = args;
  const {image, boxes, boxInd} = inputs;
  const {cropSize, method, extrapolationValue} = attrs;

  const program = new CropAndResizeProgram(
      image.shape[3], boxes.shape as [number, number], cropSize, method);
  const uniformData = [{type: 'float32', data: [extrapolationValue]}];
  return backend.runWebGPUProgram(
      program, [image, boxes, boxInd], 'float32', uniformData);
};

export const cropAndResizeConfig: KernelConfig = {
  kernelName: CropAndResize,
  backendName: 'webgpu',
  kernelFunc: cropAndResize as {} as KernelFunc
};
